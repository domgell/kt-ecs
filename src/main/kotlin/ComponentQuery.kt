import kotlin.reflect.KFunction

private typealias Type<T> = KFunction<T>

data class ComponentQuery(val wantedComponents: Set<ComponentType>, val unwantedComponents: Set<ComponentType>) {
    fun getQueryEntities(): List<EntityID> = EntityManager.getEntities(wantedComponents.toList(), unwantedComponents.toList())
}

// *** type query ***

// 1
inline fun <reified T> typeQuery(type: Type<T>): ComponentQuery {
    return ComponentQuery(setOf(T::class.simpleName.toString()), emptySet())
}

// 2
inline fun <reified T1, reified T2> typeQuery(type1: Type<T1>, type2: Type<T2>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString()), emptySet())
}

// 3
inline fun <reified T1, reified T2, reified T3> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString()), emptySet())
}

// 4
inline fun <reified T1, reified T2, reified T3, reified T4> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString()), emptySet())
}

// 5
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString()), emptySet())
}

// 6
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString()), emptySet())
}

// 7
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>, type7: Type<T7>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString(), T7::class.simpleName.toString()), emptySet())
}

// 8
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> typeQuery(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>, type7: Type<T7>, type8: Type<T8>): ComponentQuery {
    return ComponentQuery(setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString(), T7::class.simpleName.toString(), T8::class.simpleName.toString()), emptySet())
}

// *** not typeQuery ***

// 1
inline fun <reified T> ComponentQuery.not(type: Type<T>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T::class.simpleName.toString()))
}

// 2
inline fun <reified T1, reified T2> ComponentQuery.not(type1: Type<T1>, type: Type<T2>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString()))
}

// 3
inline fun <reified T1, reified T2, reified T3> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString()))
}

// 4
inline fun <reified T1, reified T2, reified T3, reified T4> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString()))
}

// 5
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString()))
}

// 6
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString()))
}

// 7
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>, type7: Type<T7>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString(), T7::class.simpleName.toString()))
}

// 8
inline fun <reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> ComponentQuery.not(type1: Type<T1>, type2: Type<T2>, type3: Type<T3>, type4: Type<T4>, type5: Type<T5>, type6: Type<T6>, type7: Type<T7>, type8: Type<T8>): ComponentQuery {
    return ComponentQuery(this.wantedComponents, this.unwantedComponents + setOf(T1::class.simpleName.toString(), T2::class.simpleName.toString(), T3::class.simpleName.toString(), T4::class.simpleName.toString(), T5::class.simpleName.toString(), T6::class.simpleName.toString(), T7::class.simpleName.toString(), T8::class.simpleName.toString()))
}

