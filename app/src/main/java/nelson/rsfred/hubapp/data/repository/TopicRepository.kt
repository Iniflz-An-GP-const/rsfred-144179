package nelson.rsfred.hubapp.data.repository

import nelson.rsfred.hubapp.data.model.Answer
import nelson.rsfred.hubapp.data.model.Question
import nelson.rsfred.hubapp.data.model.Topic

class TopicRepository {
    private val topics = listOf<Topic>(

    )

    fun getTopics(): List<Topic> = topics
}
