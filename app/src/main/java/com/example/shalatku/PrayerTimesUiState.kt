package com.example.shalatku

sealed interface PrayerTimesUiState {

    /**
     * Sedang mengambil data waktu shalat.
     */
    data object Loading : PrayerTimesUiState

    /**
     * Berhasil mengambil data.
     */
    data class Success(
        val times: List<Prayer>
    ) : PrayerTimesUiState

    /**
     * Terjadi kesalahan saat mengambil data.
     */
    data class Error(
        val message: String
    ) : PrayerTimesUiState
}