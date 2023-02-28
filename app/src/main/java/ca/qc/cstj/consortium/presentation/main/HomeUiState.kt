package ca.qc.cstj.consortium.presentation.main

import ca.qc.cstj.consortium.domain.models.Trader

sealed class HomeUiState {
    class Success(val trader: Trader) : HomeUiState()
    class Error(val message: String) : HomeUiState()
    object Empty : HomeUiState()
}