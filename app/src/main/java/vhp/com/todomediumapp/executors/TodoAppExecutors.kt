package vhp.com.todomediumapp.executors

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Executors for whole TodoTask App
 */
class TodoAppExecutors{

    companion object {

        // TodoAppExecutors singleton instance
        private var sExecutorsInstance : TodoAppExecutors?=null

        /**
         * Executor extended class to handle the Main thread
         */
        private class MainThreadExecutor : Executor{

            private var mainThreadExecutor : Handler = Handler(Looper.getMainLooper())

            override fun execute(p0: Runnable?) {
                mainThreadExecutor.post(p0)
            }

        }

        /**
         * get the singleton Instance of TodoAppExecutors
         */
        fun getInstance() : TodoAppExecutors {
            if(sExecutorsInstance == null){
                sExecutorsInstance = TodoAppExecutors(
                        Executors.newSingleThreadExecutor() ,
                        Executors.newFixedThreadPool(2),
                        MainThreadExecutor()
                )
            }

            return sExecutorsInstance as TodoAppExecutors
        }
    }
    var diskExecutor : Executor?= null
    var networkExecutor : Executor? =null
    var mainThreadExecutor : Executor? = null

    constructor(
            diskIOExecutorParam:Executor,
            networkExecutorParam: Executor ,
            mainThreadPoolExecutorParam: Executor){
        diskExecutor = diskIOExecutorParam
        networkExecutor = networkExecutorParam
        mainThreadExecutor = mainThreadPoolExecutorParam
    }

    fun getDiskIO() : Executor? {
        return diskExecutor
    }

    fun networkIO() : Executor? {
        return networkExecutor
    }

    fun mainThread() :Executor? {
        return mainThreadExecutor
    }

}



