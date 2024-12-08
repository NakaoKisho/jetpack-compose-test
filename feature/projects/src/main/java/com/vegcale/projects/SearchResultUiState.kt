package com.vegcale.projects

sealed interface SearchResultUiState {
    data object Loading : SearchResultUiState
    data object LoadFailed : SearchResultUiState
    data class Success(val query: String) : SearchResultUiState
}