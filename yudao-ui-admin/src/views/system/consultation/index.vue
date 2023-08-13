<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="孩子姓名" prop="childName">
        <el-input v-model="queryParams.childName" placeholder="请输入孩子姓名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="专业名称" prop="major">
        <el-input v-model="queryParams.major" placeholder="请输入专业名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="省市" prop="provinceCity">
        <el-input v-model="queryParams.provinceCity" placeholder="请输入省市" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="年级" prop="grade">
        <el-input v-model="queryParams.grade" placeholder="请输入年级" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分数或预估" prop="estimatedScore">
        <el-input v-model="queryParams.estimatedScore" placeholder="请输入分数或预估" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="英语分数" prop="englishScore">
        <el-input v-model="queryParams.englishScore" placeholder="请输入英语分数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="数学分数" prop="mathScore">
        <el-input v-model="queryParams.mathScore" placeholder="请输入数学分数" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="意向专业" prop="intendedMajor">
        <el-input v-model="queryParams.intendedMajor" placeholder="请输入意向专业" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="意向地区" prop="intendedArea">
        <el-input v-model="queryParams.intendedArea" placeholder="请输入意向地区" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="意向学校" prop="intendedUniversity">
        <el-input v-model="queryParams.intendedUniversity" placeholder="请输入意向学校" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="意向国家" prop="intendedCountry">
        <el-input v-model="queryParams.intendedCountry" placeholder="请输入意向国家" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="预算" prop="budget">
        <el-input v-model="queryParams.budget" placeholder="请输入预算" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="联系方式" prop="contactPhone">
        <el-input v-model="queryParams.contactPhone" placeholder="请输入联系方式" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="用户姓名" prop="userName">
        <el-input v-model="queryParams.userName" placeholder="请输入用户姓名" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['system:consultation:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:consultation:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="孩子姓名" align="center" prop="childName" />
      <el-table-column label="专业名称" align="center" prop="major" />
      <el-table-column label="省市" align="center" prop="provinceCity" />
      <el-table-column label="年级" align="center" prop="grade" />
      <el-table-column label="分数或预估" align="center" prop="estimatedScore" />
      <el-table-column label="英语分数" align="center" prop="englishScore" />
      <el-table-column label="数学分数" align="center" prop="mathScore" />
      <el-table-column label="意向专业" align="center" prop="intendedMajor" />
      <el-table-column label="意向地区" align="center" prop="intendedArea" />
      <el-table-column label="意向学校" align="center" prop="intendedUniversity" />
      <el-table-column label="意向国家" align="center" prop="intendedCountry" />
      <el-table-column label="预算" align="center" prop="budget" />
      <el-table-column label="联系方式" align="center" prop="contactPhone" />
      <el-table-column label="用户姓名" align="center" prop="userName" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:consultation:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:consultation:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="孩子姓名" prop="childName">
          <el-input v-model="form.childName" placeholder="请输入孩子姓名" />
        </el-form-item>
        <el-form-item label="专业名称" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="省市" prop="provinceCity">
          <el-input v-model="form.provinceCity" placeholder="请输入省市" />
        </el-form-item>
        <el-form-item label="年级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入年级" />
        </el-form-item>
        <el-form-item label="分数或预估" prop="estimatedScore">
          <el-input v-model="form.estimatedScore" placeholder="请输入分数或预估" />
        </el-form-item>
        <el-form-item label="英语分数" prop="englishScore">
          <el-input v-model="form.englishScore" placeholder="请输入英语分数" />
        </el-form-item>
        <el-form-item label="数学分数" prop="mathScore">
          <el-input v-model="form.mathScore" placeholder="请输入数学分数" />
        </el-form-item>
        <el-form-item label="意向专业" prop="intendedMajor">
          <el-input v-model="form.intendedMajor" placeholder="请输入意向专业" />
        </el-form-item>
        <el-form-item label="意向地区" prop="intendedArea">
          <el-input v-model="form.intendedArea" placeholder="请输入意向地区" />
        </el-form-item>
        <el-form-item label="意向学校" prop="intendedUniversity">
          <el-input v-model="form.intendedUniversity" placeholder="请输入意向学校" />
        </el-form-item>
        <el-form-item label="意向国家" prop="intendedCountry">
          <el-input v-model="form.intendedCountry" placeholder="请输入意向国家" />
        </el-form-item>
        <el-form-item label="预算" prop="budget">
          <el-input v-model="form.budget" placeholder="请输入预算" />
        </el-form-item>
        <el-form-item label="联系方式" prop="contactPhone">
          <el-input v-model="form.contactPhone" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="用户姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户姓名" />
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
import { createConsultation, updateConsultation, deleteConsultation, getConsultation, getConsultationPage, exportConsultationExcel } from "@/api/system/consultation";

export default {
  name: "Consultation",
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
      // 用户咨询列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        childName: null,
        major: null,
        provinceCity: null,
        grade: null,
        estimatedScore: null,
        englishScore: null,
        mathScore: null,
        intendedMajor: null,
        intendedArea: null,
        intendedUniversity: null,
        intendedCountry: null,
        budget: null,
        contactPhone: null,
        userName: null,
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
      getConsultationPage(this.queryParams).then(response => {
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
        childName: undefined,
        major: undefined,
        provinceCity: undefined,
        grade: undefined,
        estimatedScore: undefined,
        englishScore: undefined,
        mathScore: undefined,
        intendedMajor: undefined,
        intendedArea: undefined,
        intendedUniversity: undefined,
        intendedCountry: undefined,
        budget: undefined,
        contactPhone: undefined,
        userName: undefined,
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
      this.title = "添加用户咨询";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getConsultation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户咨询";
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
          updateConsultation(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createConsultation(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除用户咨询编号为"' + id + '"的数据项?').then(function() {
          return deleteConsultation(id);
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
      this.$modal.confirm('是否确认导出所有用户咨询数据项?').then(() => {
          this.exportLoading = true;
          return exportConsultationExcel(params);
        }).then(response => {
          this.$download.excel(response, '用户咨询.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
