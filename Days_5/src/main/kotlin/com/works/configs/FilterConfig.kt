package com.works.configs

import com.works.entities.Customer
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig : Filter {

    override fun doFilter(
        request: ServletRequest?,
        response: ServletResponse?,
        filterChain: FilterChain?
    ) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse

        val url = req.requestURI
        val arr = mutableListOf<String>("/customers")
        var status = true
        for (item in arr) {
            if (url.contains(item)) {
                status = false
            }
        }
        if (status) {
            // giriş zorunlu
            val customer = req.session.getAttribute("customer") as Customer?
            if (customer != null) {
                filterChain?.doFilter(req, res)
            }else {
                res.status = 401
                val printWriter = res.writer
                res.contentType = "application/json; charset=utf-8"
                printWriter.println("{ \"status\": false, \"message\": \"Login not found\" }")
            }
        }else {
            filterChain?.doFilter(req, res)
        }

    }

}