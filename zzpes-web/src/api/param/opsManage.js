import request from '@/utils/request'
export function createOps(data) {
  return request({
    url:'/operation/create',
    method:'post',
    data:data
  })
}

export function fetchList(params) {
  return request({
    url:'/operation/list',
    method:'get',
    params:params
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

