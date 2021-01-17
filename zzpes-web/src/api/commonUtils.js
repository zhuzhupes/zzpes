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
    method:'get',
    params:{"hahah":"kjskd"}
  });
}
