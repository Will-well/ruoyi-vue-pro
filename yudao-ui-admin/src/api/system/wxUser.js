import request from '@/utils/request'

// 创建wx用户
export function createWxUser(data) {
  return request({
    url: '/system/wx-user/create',
    method: 'post',
    data: data
  })
}

// 更新wx用户
export function updateWxUser(data) {
  return request({
    url: '/system/wx-user/update',
    method: 'put',
    data: data
  })
}

// 删除wx用户
export function deleteWxUser(id) {
  return request({
    url: '/system/wx-user/delete?id=' + id,
    method: 'delete'
  })
}

// 获得wx用户
export function getWxUser(id) {
  return request({
    url: '/system/wx-user/get?id=' + id,
    method: 'get'
  })
}

// 获得wx用户分页
export function getWxUserPage(query) {
  return request({
    url: '/system/wx-user/page',
    method: 'get',
    params: query
  })
}

// 导出wx用户 Excel
export function exportWxUserExcel(query) {
  return request({
    url: '/system/wx-user/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
