<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="大学编码" prop="code">
        <el-input v-model="queryParams.code" placeholder="请输入大学编码" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="大学名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入大学名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="大学英文名称" prop="enName">
        <el-input v-model="queryParams.enName" placeholder="请输入大学英文名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="学校logo" prop="logo">
        <el-input v-model="queryParams.logo" placeholder="请输入学校logo" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="主页图片" prop="homePic">
        <el-input v-model="queryParams.homePic" placeholder="请输入主页图片" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="简介" prop="intro">
        <el-input v-model="queryParams.intro" placeholder="请输入简介" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="申请要求" prop="applyRequirements">
        <el-input v-model="queryParams.applyRequirements" placeholder="请输入申请要求" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="所属国家" prop="country">
        <el-input v-model="queryParams.country" placeholder="请输入所属国家" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="学费" prop="tuitionFee">
        <el-input v-model="queryParams.tuitionFee" placeholder="请输入学费" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="招生方式" prop="enrollmentMethod">
        <el-input v-model="queryParams.enrollmentMethod" placeholder="请输入招生方式" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="就业" prop="employment">
        <el-input v-model="queryParams.employment" placeholder="请输入就业" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="申硕情况" prop="shengShuo">
        <el-input v-model="queryParams.shengShuo" placeholder="请输入申硕情况" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="排名" prop="qs">
        <el-input v-model="queryParams.qs" placeholder="请输入排名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="排序" prop="sort">
        <el-input v-model="queryParams.sort" placeholder="请输入排序" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['system:university:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:university:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="大学编码" align="center" prop="code" />
      <el-table-column label="大学名称" align="center" prop="name" />
      <el-table-column label="大学英文名称" align="center" prop="enName" />
      <el-table-column label="学校logo" align="center" prop="logo" />
      <el-table-column label="主页图片" align="center" prop="homePic" />
      <el-table-column label="简介" align="center" prop="intro" />
      <el-table-column label="申请要求" align="center" prop="applyRequirements" />
      <el-table-column label="所属国家" align="center" prop="country" />
      <el-table-column label="学费" align="center" prop="tuitionFee" />
      <el-table-column label="招生方式" align="center" prop="enrollmentMethod" />
      <el-table-column label="就业" align="center" prop="employment" />
      <el-table-column label="申硕情况" align="center" prop="shengShuo" />
      <el-table-column label="排名" align="center" prop="qs" />
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:university:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:university:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="大学编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入大学编码" />
        </el-form-item>
        <el-form-item label="大学名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入大学名称" />
        </el-form-item>
        <el-form-item label="大学英文名称" prop="enName">
          <el-input v-model="form.enName" placeholder="请输入大学英文名称" />
        </el-form-item>
        <el-form-item label="学校logo" prop="logo">
          <el-input v-model="form.logo" placeholder="请输入学校logo" />
        </el-form-item>
        <el-form-item label="主页图片" prop="homePic">
          <el-input v-model="form.homePic" placeholder="请输入主页图片" />
        </el-form-item>
        <el-form-item label="简介" prop="intro">
          <el-input v-model="form.intro" placeholder="请输入简介" />
        </el-form-item>
        <el-form-item label="申请要求" prop="applyRequirements">
          <el-input v-model="form.applyRequirements" placeholder="请输入申请要求" />
        </el-form-item>
        <el-form-item label="所属国家" prop="country">
          <el-input v-model="form.country" placeholder="请输入所属国家" />
        </el-form-item>
        <el-form-item label="学费" prop="tuitionFee">
          <el-input v-model="form.tuitionFee" placeholder="请输入学费" />
        </el-form-item>
        <el-form-item label="招生方式" prop="enrollmentMethod">
          <el-input v-model="form.enrollmentMethod" placeholder="请输入招生方式" />
        </el-form-item>
        <el-form-item label="就业" prop="employment">
          <el-input v-model="form.employment" placeholder="请输入就业" />
        </el-form-item>
        <el-form-item label="申硕情况" prop="shengShuo">
          <el-input v-model="form.shengShuo" placeholder="请输入申硕情况" />
        </el-form-item>
        <el-form-item label="排名" prop="qs">
          <el-input v-model="form.qs" placeholder="请输入排名" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createUniversity, updateUniversity, deleteUniversity, getUniversity, getUniversityPage, exportUniversityExcel } from "@/api/system/university";

export default {
  name: "University",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学校列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        code: null,
        name: null,
        enName: null,
        logo: null,
        homePic: null,
        intro: null,
        applyRequirements: null,
        country: null,
        tuitionFee: null,
        enrollmentMethod: null,
        employment: null,
        shengShuo: null,
        qs: null,
        sort: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getUniversityPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        code: undefined,
        name: undefined,
        enName: undefined,
        logo: undefined,
        homePic: undefined,
        intro: undefined,
        applyRequirements: undefined,
        country: undefined,
        tuitionFee: undefined,
        enrollmentMethod: undefined,
        employment: undefined,
        shengShuo: undefined,
        qs: undefined,
        sort: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学校";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getUniversity(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学校";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updateUniversity(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createUniversity(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除学校编号为"' + id + '"的数据项?').then(function() {
          return deleteUniversity(id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有学校数据项?').then(() => {
          this.exportLoading = true;
          return exportUniversityExcel(params);
        }).then(response => {
          this.$download.excel(response, '学校.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
