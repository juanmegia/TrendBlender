package com.example.trendblender.viewModel

    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.example.trendblender.apiFits.MainRepository
    import com.example.trendblender.models.Outfit
    import com.example.trendblender.models.Piece
    import com.example.trendblender.models.User
    import kotlinx.coroutines.Dispatchers.Main
    import kotlinx.coroutines.GlobalScope
    import kotlinx.coroutines.launch

    class MainViewModel : ViewModel() {

        private var repository: MainRepository = MainRepository()

        fun getPieceList(userId: String?): MutableLiveData<List<Piece>> {
            val pieces = MutableLiveData<List<Piece>>()
            GlobalScope.launch(Main) {
                pieces.value = repository.getPieceList(userId)
            }
            return pieces
        }

        fun createPiece(piece: Piece): MutableLiveData<Piece> {
            val createdPiece = MutableLiveData<Piece>()
            GlobalScope.launch(Main) {
                createdPiece.value = repository.createPiece(piece)
            }
            return createdPiece
        }

        fun getPieceDetail(id: String): MutableLiveData<Piece> {
            val pieceDetail = MutableLiveData<Piece>()
            GlobalScope.launch(Main) {
                pieceDetail.value = repository.getPieceDetail(id)
            }
            return pieceDetail
        }

        fun updatePiece(id: String, piece: Piece): MutableLiveData<Piece> {
            val updatedPiece = MutableLiveData<Piece>()
            GlobalScope.launch(Main) {
                updatedPiece.value = repository.updatePiece(id, piece)
            }
            return updatedPiece
        }

        fun deletePiece(id: String): MutableLiveData<Boolean> {
            val isDeleted = MutableLiveData<Boolean>()
            GlobalScope.launch(Main) {
                isDeleted.value = repository.deletePiece(id)
            }
            return isDeleted
        }

        fun getPieceCategory(category: String?, color: String?, size: String?, userId: String?): MutableLiveData<List<Piece>> {
            val filteredPieces = MutableLiveData<List<Piece>>()
            GlobalScope.launch(Main) {
                filteredPieces.value = repository.getPieceCategory(category, color, size, userId)
            }
            return filteredPieces
        }

        fun getOutfitList(userId: String?): MutableLiveData<List<Outfit>> {
            val outfits = MutableLiveData<List<Outfit>>()
            GlobalScope.launch(Main) {
                outfits.value = repository.getOutfitList(userId)
            }
            return outfits
        }

        fun createOutfit(outfit: Outfit): MutableLiveData<Outfit> {
            val createdOutfit = MutableLiveData<Outfit>()
            GlobalScope.launch(Main) {
                createdOutfit.value = repository.createOutfit(outfit)
            }
            return createdOutfit
        }

        fun updateOutfit(outfitId: String, outfit: Outfit): MutableLiveData<Outfit> {
            val updatedOutfit = MutableLiveData<Outfit>()
            GlobalScope.launch(Main) {
                updatedOutfit.value = repository.updateOutfit(outfitId, outfit)
            }
            return updatedOutfit
        }

        fun createUser(user: User): MutableLiveData<Boolean> {
            val isUserCreated = MutableLiveData<Boolean>()
            GlobalScope.launch(Main) {
                isUserCreated.value = repository.createUser(user)
            }
            return isUserCreated
        }

        fun generateOutfit(userId: String, style: String?, weather: String?, categories: List<String>): MutableLiveData<Outfit> {
            val generatedOutfit = MutableLiveData<Outfit>()
            GlobalScope.launch(Main) {
                generatedOutfit.value = repository.generateOutfit(userId, style, weather, categories)
            }
            return generatedOutfit
        }
    }