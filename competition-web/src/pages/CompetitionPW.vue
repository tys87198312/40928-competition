<template>
  <div class="q-pa-md">
    <!--主体-->
    <q-table
      ref="completitionTable"
      title="比赛大厅"
      :rows="rows"
      :columns="columns"
      color="primary"
      :pagination="myPagination"
      :visible-columns="visibleColumns"
      row-key="id"
      selection="single"
      v-model:selected="selected"
    >
      <template v-slot:top-right>
        <div>
          <q-input borderless dense debounce="300" v-model="params.filter" placeholder="标题">
            <template v-slot:append>
              <q-icon name="search" @click="dataList"/>
            </template>
          </q-input>
          <div class="q-pt-lg" style="display: flex; flex-direction: row">
            <div class="q-px-md">
              <q-btn
                color="primary"
                label="报名"
                size="md"
                no-caps
                :disable="yesJoinDisable"
                @click="yesJoin"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="primary"
                label="退出"
                size="md"
                no-caps
                :disable="noJoinDisable"
                @click="noJoin"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="red"
                label="详情"
                size="md"
                :disable="detailDisable"
                no-caps
                @click="detail"
              />
            </div>
          </div>
        </div>
      </template>
    </q-table>
  </div>


  <!--diag-->
  <q-dialog v-model="dialogOpen">
    <q-card style=" width: 800px; height: 690px" class="q-py-xs">

      <q-card-section align="top">
        <h6 class="text-left">比赛情况</h6>
        <span class="text-overline">是否开始：未开始</span><br>
        <span class="text-overline">开始时间：2022-01-10</span>
      </q-card-section>

      <q-card-section tag="div">
        <h6 class="text-left">选手名单</h6>
        <q-list>
          <q-item dense v-for="(item) in details.xs" :key="item" class="items-lg-center">
            <div class="text-overline">姓名： {{item.userName}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 分数： {{item.score == null? '未打分' : item.score}}</div>
          </q-item>
        </q-list>
      </q-card-section >

      <q-card-section tag="div">
        <h6 class="h1 text-left">评委名单</h6>
        <q-list>
          <q-item dense v-for="(item) in details.pw" :key="item" class="items-lg-center">
            <div class="text-overline">姓名： {{item.userName}}</div>
          </q-item>
        </q-list>
      </q-card-section>

      <q-card-actions align="right" style="height: 50px">
        <q-btn  label="取消" color="primary" v-close-popup  />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
  import { useCounterStore } from 'stores/global';
  const store = useCounterStore();
  const columns = [
    {
      name: 'id',
      label: 'id',
      align: 'center',
      field: row => row.id,
      format: val => `${val}`
    },
    {
      name: 'title',
      label: '标题',
      align: 'center',
      field: row => row.title,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'startTime',
      label: '比赛开始时间',
      align: 'center',
      field: row => row.startTime,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'statusMean',
      label: '比赛状态',
      align: 'center',
      field: row => row.statusMean,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'judgePerson',
      label: '评分人',
      align: 'center',
      field: row => row.judgePerson,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'isJoin',
      label: '是否报名',
      align: 'center',
      field: row => row.isJoin,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'createBy',
      label: '创建人',
      align: 'center',
      field: row => row.createBy,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'createTime',
      label: '创建时间',
      align: 'center',
      field: row => row.createTime,
      format: val => `${val}`,
      sortable: true
    }
  ]
  const myPagination = {
    sortBy: 'createTime',
    descending: true,
    rowsPerPage: 10
  }
  export default {
    name: 'UserManageer',
    data () {
      return {
        myPagination: myPagination,
        rows: [],
        columns: columns,
        visibleColumns: ['title','startTime','statusMean','createBy','createTime', 'judgePerson', 'isJoin'],
        selected: [],
        dialogOpen: false,
        params: {
          rowsPerPage: 10,
          page: 0,
          filter: null
        },
        competition: {
          id: null,
          title: null,
          startTime: ''
        },
        details: null
      }
    },
    computed: {
      detailDisable () {
        return this.selected.length == 0 ? true : false
      },
      yesJoinDisable () {
        return this.selected.length > 0 && this.selected[0].isJoin == '未报名' ? false : true
      },
      noJoinDisable () {
        return this.selected.length > 0 && this.selected[0].isJoin == '已报名' ? false : true
      },
    },
    mounted() {
      this.dataList()
    },
    methods: {
      dataList () {
        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.get('competition/list', {
          params: this.params
        }).then((response) => {
          let result = response.data
          /*结果校验*/
          if (result.code != '200') {
            this.$q.notify({
              message: result.msg,
              color: 'red',
              position: 'top'
            })
            return
          }
          this.rows = result.data.list
          console.log(JSON.stringify(this.rows))
        })
      },
      yesJoin () {
        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.get('competition/join', {
          params: {
            competitionId: this.selected[0].id
          }
        }).then((response) => {
          let result = response.data
          /*结果校验*/
          if (result.code != '200') {
            this.$q.notify({
              message: result.msg,
              color: 'red',
              position: 'top'
            })
            return
          }
          this.$q.notify({
            message: '操作成功',
            color: 'primary',
            position: 'top'
          })

          this.dataList()
          this.$refs.completitionTable.clearSelection()
        })
      },
      noJoin () {

        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.get('competition/noJoin', {
          params: {
            competitionId: this.selected[0].id
          }
        }).then((response) => {
          let result = response.data
          /*结果校验*/
          if (result.code != '200') {
            this.$q.notify({
              message: result.msg,
              color: 'red',
              position: 'top'
            })
            return
          }
          this.$q.notify({
            message: '操作成功',
            color: 'primary',
            position: 'top'
          })
          this.dataList()
          this.$refs.completitionTable.clearSelection()
        })

      },
      detail () {

        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.get('competition/detail', {
          params: {
            competitionId: this.selected[0].id
          }
        }).then((response) => {
          let result = response.data
          /*结果校验*/
          if (result.code != '200') {
            this.$q.notify({
              message: result.msg,
              color: 'red',
              position: 'top'
            })
            return
          }
          this.details = result.data
          console.log(this.details)



          this.dialogOpen = true

        })

      }
    }
  }
</script>
