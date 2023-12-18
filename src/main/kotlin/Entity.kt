import java.util.*

interface Entity {
    val id: String
}

inline fun <reified T> EntityID.get(): T {
    val entity = EntityManager.entities[this] ?: throw IllegalArgumentException("Invalid entity ID")

    val component = entity[T::class.simpleName]
        ?: throw IllegalArgumentException("The entity doesn't have a ${T::class.simpleName} component.")

    return component as T
}

inline fun <reified T : Any> Entity.addComponent(component: T) = EntityManager.newComponent(id, component)

fun createUUID(): String = UUID.randomUUID().toString()

