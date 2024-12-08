package com.vegcale.projects

sealed interface QueryUiState {
    data object Loading : QueryUiState
    data object LoadFailed : QueryUiState
    data class Success(val query: String) : QueryUiState
}