package team.uptech.training.navigation.data.mappers

import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.PostNetwork
import team.uptech.training.navigation.data.model.PostPreviewNetwork
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.Post
import team.uptech.training.navigation.domain.model.PostPreview
import team.uptech.training.navigation.utils.mapper.ListMapper
import team.uptech.training.navigation.utils.mapper.Mapper


object PostDataToDomainMapper {
  val postPreviewMapper = Mapper<DataList<PostPreviewNetwork>, PagedList<PostPreview>> { input ->
    PagedList(
      data = postPreviewListMapper.map(input.data),
      total = input.total,
      page = input.page,
      limit = input.limit
    )
  }

  val postPreviewModelMapper = Mapper<PostPreviewNetwork, PostPreview> { input ->
    PostPreview(
      input.id,
      input.text,
      input.image,
      input.likes,
      input.tags,
      input.publishDate,
      UserDataToDomainMapper.userPreviewModelMapper.map(input.owner)
    )
  }

  val postPreviewListMapper = ListMapper<PostPreviewNetwork, PostPreview> { input ->
    if (input.size > 50) {
      input.asSequence().map { postPreviewModelMapper.map(it) }.toList()
    } else {
      input.map { postPreviewModelMapper.map(it) }
    }
  }

  val postModelMapper = Mapper<PostNetwork, Post> { input ->
    Post(
      input.id,
      input.text,
      input.image,
      input.likes,
      input.link,
      input.tags,
      input.publishDate,
      UserDataToDomainMapper.userPreviewModelMapper.map(input.owner)
    )
  }

}