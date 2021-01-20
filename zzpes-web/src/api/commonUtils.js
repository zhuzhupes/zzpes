import request from '@/utils/request'

/**
 * 获取所有链接
 * @param url 链接名字
 * @returns {*} 返回的数据
 */
export function fetchList(url) {
  url = url+'/allList';
  return request({
    url: url,
    method:'get'
  });
}


export function checkIsIn(option, list, key){
  if(key == null || key == ''){
    return list.findIndex((item, i)=>{
      return item === option
    });
  }else{
    return list.findIndex((item, i)=>{
      return item[key] === option[key]
    });
  }
}
