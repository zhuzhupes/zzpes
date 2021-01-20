import request from '@/utils/request'

/**
 * 模糊查询
 * @param url 链接名字
 * @returns {*} 返回的数据
 */
export function vagueDtlQry(dtlType, dtlTypeDtl, value) {
  return request({
    url: '/jx3DtlInfo/vagueQry',
    method:'post',
    data:{"dtlType":dtlType,
      "dtlTypeDtl":dtlTypeDtl,
      "value":value,
    }
  });
}
