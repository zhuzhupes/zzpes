import request from '@/utils/request'
export function createUnit(data) {
  return request({
    url:'/unit/create',
    method:'post',
    data:data
  })
}

export function fetchList(params) {
  return request({
    url:'/unit/list',
    method:'get',
    params:params
  })
}

export function updateUnitInfo(id,data) {
  return request({
    url:'/unit/update/'+id,
    method:'post',
    data:data
  })
}

export function deleteUnitInfo(id) {
  return request({
    url:'/unit/delete/'+id,
    method:'get'
  })
}

