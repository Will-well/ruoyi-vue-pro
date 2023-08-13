import request from '@/utils/request'

// 创建学校
export function createUniversity(data) {
  return request({
    url: '/system/university/create',
    method: 'post',
    data: data
  })
}

// 更新学校
export function updateUniversity(data) {
  return request({
    url: '/system/university/update',
    method: 'put',
    data: data
  })
}

// 删除学校
export function deleteUniversity(id) {
  return request({
    url: '/system/university/delete?id=' + id,
    method: 'delete'
  })
}

// 获得学校
export function getUniversity(id) {
  return request({
    url: '/system/university/get?id=' + id,
    method: 'get'
  })
}

// 获得学校分页
export function getUniversityPage(query) {
  return request({
    url: '/system/university/page',
    method: 'get',
    params: query
  })
}

// 导出学校 Excel
export function exportUniversityExcel(query) {
  return request({
    url: '/system/university/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
