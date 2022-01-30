package team.uptech.training.navigation.data.source.post

import kotlinx.coroutines.flow.Flow
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.PostPreview


interface PostRemoteDataSource {
  fun getPosts(): Flow<PagedList<PostPreview>>
}