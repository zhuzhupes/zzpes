import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url:'/symptom.js/list',
    method:'get',
    params:params
  })
}

export function operUnitAllList() {
  return request({
    url:'/operationUnit/allList',
    method:'get'
  })
}

export function updateOpts(id,data) {
  return request({
    url:'/operation/update/'+id,
    method:'post',
    data:data
  })
}

export function deleteOpts(id) {
  return request({
    url:'/operation/delete/'+id,
    method:'get'
  })
}

