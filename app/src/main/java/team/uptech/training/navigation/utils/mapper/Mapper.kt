package team.uptech.training.navigation.utils.mapper


fun interface Mapper<I, O> {
  fun map(input: I): O
}