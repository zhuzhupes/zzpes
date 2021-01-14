import request from '@/utils/request'
export function create(data) {
  return request({
    url:'/prescription/create',
    method:'post',
    data:data
  })
}


