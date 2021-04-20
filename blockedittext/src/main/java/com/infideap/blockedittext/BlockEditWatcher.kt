package com.infideap.blockedittext

interface BlockEditWatcher {
    fun onBlockTextChanged(s: CharSequence?, blockNumber: Int)
}