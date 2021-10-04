package user.dto

data class UserDetailsDto(
        val phoneNumber: String,
        val address: String,
        val city: String,
        val country: String,
        val postCode: String) {
}