package oj.sdb

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class Rest(val userDB: UserDB, val actorDB: ActorDB) {
    @PostMapping("createuser")
    fun createUser(@RequestBody user: User): User = userDB.save(user)
}

data class User(var id: String? = null, val username: String)
data class Actor(var id: String? = null, val username: String)

interface UserDB : MongoRepository<User, String> {}
interface ActorDB : MongoRepository<Actor, String> {}
