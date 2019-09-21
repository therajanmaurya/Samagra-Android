package com.example.samagra.android.models

data class ProcessTime(

    var startFetchTime: Long = System.currentTimeMillis() / 1000,

    var endFetchTime: Long = 0,

    var startSaveTime: Long = 0,

    var endSaveTime: Long = 0
)