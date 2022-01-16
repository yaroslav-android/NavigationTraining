package team.uptech.training.navigation.utils.mapper


interface Mapper<I, O> {
  fun map(input: I): O
}