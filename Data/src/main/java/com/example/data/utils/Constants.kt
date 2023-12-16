package com.example.data.utils

class Constants {

    object BaseUrl {
        private const val PRIVATE_BASE_URL = "https://staging.mazaady.com"
        const val BASE_URL = PRIVATE_BASE_URL
    }

    object Errors {
        const val OFFLINE_MODE = "You are offline try again to update pets"

        const val UNKNOWN_ERROR = "there is a problem in your internet connection please try again"

    }

    object Credentials {

        private const val _PrivateKey = "3%o8i}_;3D4bF]G5@22r2)Et1&mLJ4?\$@+16"

        const val PrivateKey = _PrivateKey

    }


}