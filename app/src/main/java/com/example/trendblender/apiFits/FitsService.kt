package com.example.trendblender.apiFits
import com.example.trendblender.models.Outfit
import com.example.trendblender.models.Piece
import com.example.trendblender.models.Respuesta
import com.example.trendblender.models.User
import retrofit2.Response
import retrofit2.http.*
import kotlinx.coroutines.Deferred
interface FitsService {
    @GET("pieces/")
    suspend fun getPieceList(@Query("user_id") userId: String?):  Deferred<Response<Respuesta>>

    @POST("pieces/")
    suspend fun createPiece(@Body piece: Piece):  Deferred<Response<Respuesta>>

    @GET("pieces/{id}")
    suspend fun getPieceDetail(@Path("id") id: String):  Deferred<Response<Respuesta>>

    @PUT("pieces/{id}")
    suspend fun updatePiece(@Path("id") id: String, @Body piece: Piece): Deferred<Response<Respuesta>>

    @DELETE("pieces/{id}")
    suspend fun deletePiece(@Path("id") id: String):  Deferred<Response<Respuesta>>
    @GET("users/")
    suspend fun getUserByUsername(@Query("username") username: String): Response<Respuesta>

    @GET("piece_category/")
    suspend fun getPieceCategory(
        @Query("category") category: String?,
        @Query("color") color: String?,
        @Query("size") size: String?,
        @Query("user_id") userId: String?
    ): Deferred<Response<Respuesta>>

    @GET("outfit_list/")
    suspend fun getOutfitList(@Query("user_id") userId: String?):  Deferred<Response<Respuesta>>

    @POST("create_outfit/")
    suspend fun createOutfit(@Body outfit: Outfit):  Deferred<Response<Respuesta>>

    @PUT("update_outfit/{outfit_id}")
    suspend fun updateOutfit(@Path("outfit_id") outfitId: String, @Body outfit: Outfit):  Deferred<Response<Respuesta>>

    @POST("create_user/")
    suspend fun createUser(@Body user: User):  Deferred<Response<Respuesta>>

    @GET("generate_outfit_view/")
    suspend fun generateOutfit(
        @Query("user_id") userId: String,
        @Query("style") style: String?,
        @Query("weather") weather: String?,
        @Query("categories") categories: List<String>
    ):  Deferred<Response<Respuesta>>
}
