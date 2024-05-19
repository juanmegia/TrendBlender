package com.example.trendblender.models
import java.util.UUID
import java.io.Serializable

data class PieceCategory(
    val id: UUID,
    val name: String,
    val bodypart: String
) : Serializable

data class Piece(
    val id: UUID,
    val user: UUID, // Assuming this is UUID of the user
    val name: String?,
    val brand: String?,
    val style: String,
    val color: String,
    val category: PieceCategory?,
    val description: String?,
    val size: String?,
    val image: String?
) : Serializable

data class Outfit(
    val id: UUID,
    val user: UUID, // Assuming this is UUID of the user
    val name: String,
    val pieces: List<Piece>
) : Serializable
data class User(
    val id: UUID,
    val username: String,
    val password: String
): Serializable
data class Respuesta(
    val pieces: List<Piece>,
    val piece: Piece,
    val outfit: Outfit,
    val outfits: List<Outfit>,
    val usuario: User
) : Serializable