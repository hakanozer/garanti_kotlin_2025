package com.works.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Util {
    companion object {

        fun ok(obj: Any): ResponseEntity<Any> {
            val map = mutableMapOf<String, Any>()
            map.put("status", true)
            map.put("message", "OK")
            map.put("result", obj)
            return ResponseEntity(map,HttpStatus.OK)
        }

        fun fail(obj: Any, httpStatus: HttpStatus): ResponseEntity<Any> {
            val map = mutableMapOf<String, Any>()
            map.put("status", false)
            map.put("message", httpStatus.reasonPhrase)
            map.put("result", obj)
            return ResponseEntity(map,httpStatus)
        }

    }
}