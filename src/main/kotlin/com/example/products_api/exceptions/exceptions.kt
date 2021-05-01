package com.example.products_api.exceptions

import java.lang.RuntimeException

class QrCodeUnavailableException(override val message: String): RuntimeException()