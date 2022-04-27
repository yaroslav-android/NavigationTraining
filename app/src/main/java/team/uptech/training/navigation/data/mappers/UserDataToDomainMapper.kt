package team.uptech.training.navigation.data.mappers

import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.UserNetwork
import team.uptech.training.navigation.data.model.UserPreviewNetwork
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.User
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

  val userListMapper = Mapper<DataList<UserPreviewNetwork>, PagedList<UserPreview>> { input ->
    PagedList(
      input.data.map { userPreviewModelMapper.map(it) },
      input.total,
      input.page,
      input.limit
    )
  }

  val userModelMapper = Mapper<UserNetwork, User> { input ->
    User(
      input.id,
      input.title.orEmpty(),
      input.firstName,
      input.lastName,
      input.gender.orEmpty(),
      input.email,
      input.dateOfBirth.orEmpty(),
      input.registerDate,
      input.phone.orEmpty(),
      input.picture.orEmpty(),
      LocationDataToDomainMapper.mapper.map(input.location),
    )
  }
}