package com.rumeysaozer.roomdaggerhilt.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType>networkBoundResource(
   crossinline query: () -> Flow<ResultType>,
   crossinline  fetch : suspend () -> RequestType,
   crossinline saveFetchResult : suspend (RequestType) -> Unit,
   crossinline  shouldFetch : (ResultType) -> Boolean = { true}
) = flow {
    val data = query().first()
   val flow =  if(shouldFetch(data)){
        emit(Resource.Loading(data))
        try{
            saveFetchResult(fetch())
            query().map { Resource.Succes(it) }
        }catch(throwable: Throwable){
           query().map { Resource.Error(throwable,it) }
        }
    }else{
        query().map { Resource.Succes(it) }
    }
    emitAll(flow)
}