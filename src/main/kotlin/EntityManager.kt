typealias EntityID = String
typealias ComponentType = String

object EntityManager {
    // Entity ID to map of component type to instance
    val entities = mutableMapOf<EntityID, MutableMap<ComponentType, Any>>()

    // Component type to set of entity ids with that component
    private val componentTypes = mutableMapOf<ComponentType, MutableSet<EntityID>>()

    // TODO Add components in chunks each update
    fun <T : Any> newComponent(id: EntityID, component: T) {
        val name = component::class.simpleName!!
        // Add to the global components instances of this type
        componentTypes.computeIfAbsent(name) { mutableSetOf() }.add(id)
        // Add to the entity's components list and initialize the entity if not already
        entities.computeIfAbsent(id) { mutableMapOf() }[name] = component

        // TODO Add to systems
        systems.forEach {
            if (it.key.query.wantedComponents.contains(name))
                it.value.add(id)
        }
    }

    // TODO Faster version with Set<ComponentType> for system initialization
    fun getEntities(componentTypes: List<ComponentType>, unwantedTypes: List<ComponentType>? = null): List<EntityID> {
        // Entities with any of the component types
        val allEntities = componentTypes.map { this.componentTypes[it]!! }
        // Entities with all the component types
        val wantedEntities = allEntities.reduce { acc, set -> acc.intersect(set) as MutableSet<EntityID> }
        // Filter out entities with unwanted types
        if (!unwantedTypes.isNullOrEmpty()) {
            // All entities with the unwanted types
            val allUnwantedEntities = unwantedTypes.map { this.componentTypes[it] ?: emptySet() }
            // Unwanted entities with any of the unwanted types
            val unwantedEntities = allUnwantedEntities.reduce { acc, set -> acc.union(set) }.toSet()
            // Remove unwantedEntities from wantedEntities
            wantedEntities.removeAll(unwantedEntities)
        }
        return wantedEntities.toList()
    }

    val systems = mutableMapOf<BaseSystem, ArrayList<EntityID>>()
    fun newSystem(system: BaseSystem) {
        systems[system] = ArrayList(system.query.getQueryEntities())
    }
}