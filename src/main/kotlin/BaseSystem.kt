interface BaseSystem {
    val query: ComponentQuery
}

val BaseSystem.entities: ArrayList<EntityID>
    get() = EntityManager.systems.getOrElse(this) { EntityManager.newSystem(this); EntityManager.systems[this]!! }
