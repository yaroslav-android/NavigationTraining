package team.uptech.training.navigation.data.mappers

import team.uptech.training.navigation.data.model.UserPreviewNetwork
import team.uptech.training.navigation.domain.model.UserPreview
import team.uptech.training.navigation.utils.mapper.Mapper


object UserDataToDomainMapper {

  val userPreviewModelMapper = Mapper<UserPreviewNetwork, UserPreview> { input ->
    UserPreview(
      input.id,
      input.title.orEmpty(),
      input.firstName,
      input.lastName,
      input.picture.orEmpty()
    )
  }
}