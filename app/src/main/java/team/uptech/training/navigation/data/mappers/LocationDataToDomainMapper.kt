package team.uptech.training.navigation.data.mappers

import team.uptech.training.navigation.data.model.LocationNetwork
import team.uptech.training.navigation.domain.model.Location
import team.uptech.training.navigation.utils.mapper.Mapper


object LocationDataToDomainMapper {
  val mapper = Mapper<LocationNetwork?, Location> { input ->
    Location(
      input?.street.orEmpty(),
      input?.city.orEmpty(),
      input?.state.orEmpty(),
      input?.country.orEmpty(),
      input?.timezone.orEmpty()
    )
  }
}