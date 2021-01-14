import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url:'/patient/list',
    method:'get',
    params:params
  })
}

export function patientAllList() {
  return request({
    url:'/patient/allList',
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

