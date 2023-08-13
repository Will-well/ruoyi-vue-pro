import request from '@/utils/request'

// 创建专业
export function createMajor(data) {
  return request({
    url: '/system/major/create',
    method: 'post',
    data: data
  })
}

// 更新专业
export function updateMajor(data) {
  return request({
    url: '/system/major/update',
    method: 'put',
    data: data
  })
}

// 删除专业
export function deleteMajor(id) {
  return request({
    url: '/system/major/delete?id=' + id,
    method: 'delete'
  })
}

// 获得专业
export function getMajor(id) {
  return request({
    url: '/system/major/get?id=' + id,
    method: 'get'
  })
}

// 获得专业分页
export function getMajorPage(query) {
  return request({
    url: '/system/major/page',
    method: 'get',
    params: query
  })
}

// 导出专业 Excel
export function exportMajorExcel(query) {
  return request({
    url: '/system/major/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
