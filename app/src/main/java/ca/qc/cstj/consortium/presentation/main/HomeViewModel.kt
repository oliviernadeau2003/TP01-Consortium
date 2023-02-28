package ca.qc.cstj.consortium.presentation.main

import androidx.lifecycle.ViewModel
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val trader = Trader("DefaultTrader", 200f, 200f, 200f, 200f, 200f)

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Empty)
    val homeUiState = _homeUiState.asStateFlow()

    init {
        _homeUiState.update {
            HomeUiState.Success(trader)
        }
    }

    fun reloadCargo() {
        trader.reload()
        _homeUiState.value = HomeUiState.Success(trader)
    }

    fun emptyCargo() {
        trader.upload()
        _homeUiState.value = HomeUiState.Success(trader)
    }
}