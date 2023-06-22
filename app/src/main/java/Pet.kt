enum class Kind{
    CAT, DOG , RABBIT
}

data class Pet(
    val name: String,
    val vaccinated: Boolean,
    val age: Float,
    val kind: Kind
)