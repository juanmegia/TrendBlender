package com.example.trendblender.apiFits

    import com.example.trendblender.models.Piece;
    import com.example.trendblender.models.Outfit;
    import com.example.trendblender.models.User

class MainRepository {

        // Accede a fitsService directamente desde FitsAccess
        val fitsService = FitsAccess.fitsService;
        suspend fun getPieceList(userId: String?): List<Piece> {
            val webResponse = fitsService.getPieceList(userId).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.pieces ?: emptyList();
            } else {
                emptyList();
            }
        }

        suspend fun createPiece(piece: Piece): Piece? {
            val webResponse = fitsService.createPiece(piece).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.piece
            } else {
                null
            }
        }

        suspend fun getPieceDetail(id: String): Piece? {
            val webResponse = fitsService.getPieceDetail(id).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.piece
            } else {
                null
            }
        }

        suspend fun updatePiece(id: String, piece: Piece): Piece? {
            val webResponse = fitsService.updatePiece(id, piece).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.piece
            } else {
                null
            }
        }

        suspend fun deletePiece(id: String): Boolean {
            val webResponse = fitsService.deletePiece(id).await()
            return webResponse.isSuccessful
        }

        suspend fun getPieceCategory(
            category: String?,
            color: String?,
            size: String?,
            userId: String?
        ): List<Piece> {
            val webResponse = fitsService.getPieceCategory(category, color, size, userId).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.pieces ?: emptyList()
            } else {
                emptyList()
            }
        }

        suspend fun getOutfitList(userId: String?): List<Outfit> {
            val webResponse = fitsService.getOutfitList(userId).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.outfits ?: emptyList()
            } else {
                emptyList()
            }
        }

        suspend fun createOutfit(outfit: Outfit): Outfit? {
            val webResponse = fitsService.createOutfit(outfit).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.outfit
            } else {
                null
            }
        }

        suspend fun updateOutfit(outfitId: String, outfit: Outfit): Outfit? {
            val webResponse = fitsService.updateOutfit(outfitId, outfit).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.outfit
            } else {
                null
            }
        }

        suspend fun createUser(user: User): Boolean {
            val webResponse = fitsService.createUser(user).await()
            return webResponse.isSuccessful
        }

        suspend fun generateOutfit(userId: String, style: String?, weather: String?, categories: List<String>): Outfit? {
            val webResponse = fitsService.generateOutfit(userId, style, weather, categories).await()
            return if (webResponse.isSuccessful) {
                webResponse.body()?.outfit
            } else {
                null
            }
        }
    }
