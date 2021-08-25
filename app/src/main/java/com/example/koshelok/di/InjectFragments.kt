package com.example.koshelok.di

import com.example.koshelok.di.injectfragments.categoryfragments.InjectCategoryFragments
import com.example.koshelok.di.injectfragments.transactionfragments.InjectTransactionFragments
import com.example.koshelok.di.injectfragments.walletfragments.InjectWalletFragments

interface InjectFragments :
    InjectCategoryFragments,
    InjectTransactionFragments,
    InjectWalletFragments
