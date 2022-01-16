package team.uptech.training.navigation.data.mappers

import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.utils.mapper.Mapper


object TagDataToDomainMapper {
  val mapper = Mapper<DataList<String>, PagedList<String>> { input ->
    PagedList(
      data = input.data,
      total = input.total,
      page = input.page,
      limit = input.limit
    )
  }
}