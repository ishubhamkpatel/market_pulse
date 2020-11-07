package com.shubham.marketpulse.di.module.data

import com.shubham.marketpulse.data.DataHelper
import com.shubham.marketpulse.data.DataManager
import com.shubham.marketpulse.data.local.DbHelper
import com.shubham.marketpulse.data.local.DbManager
import com.shubham.marketpulse.data.remote.Api
import com.shubham.marketpulse.data.remote.ApiHelper
import com.shubham.marketpulse.data.remote.ApiManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
class DataProviderModule {

    @Provides
    @Singleton
    internal fun provideDataManager(
        apiHelper: ApiHelper,
        dbHelper: DbHelper
    ): DataHelper {
        return DataManager(apiHelper, dbHelper)
    }

    @Provides
    @Singleton
    internal fun provideApiManager(api: Api): ApiHelper {
        return ApiManager(api)
    }

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    internal fun provideDbManager(): DbHelper {
        return DbManager()
    }
}