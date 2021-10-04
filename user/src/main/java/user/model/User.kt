package user.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User2(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mail: String,
    val firstName: String,
    val lastName: String,
    val middleName: String
) {
    constructor(mail: String,
                firstName: String,
                lastName: String,
                middleName: String) : this(null,mail,firstName,lastName,middleName){

                }


}
