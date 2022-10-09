<template>
  <div class="q-pa-md">
    <!--主体-->
    <q-table
      title="比赛管理"
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
                label="新增"
                size="md"
                no-caps
                @click="add"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="primary"
                label="修改"
                size="md"
                no-caps
                @click="update"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="red"
                label="删除"
                size="md"
                no-caps
                @click="del"
              />
            </div>
          </div>
        </div>
      </template>
    </q-table>
  </div>


  <!--diag-->
  <q-dialog v-model="dialogOpen"  transition-show="rotate" transition-hide="rotate">
    <q-card style=" width: 800px; height: 690px">
      <q-card-section>
        <div class="text-h6">{{opt == 'add' ? '新增': '修改'}}比赛</div>
      </q-card-section>

      <q-card-section class="q-gutter-md">
        <q-input filled label="标题" v-model="competition.title"></q-input>
        <q-input filled label="开始时间" v-model="competition.startTime"></q-input>

        <div style="display: flex; flex-direction: row">
          <q-date v-model="competition.startTime" mask="YYYY-MM-DD HH:mm:ss" />
          <q-time v-model="competition.startTime" mask="YYYY-MM-DD HH:mm:ss" />
        </div>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn  label="取消" color="primary" v-close-popup  />
        <q-btn  label="提交" color="primary" @click="submitForm" />
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
      name: 'status',
      label: '比赛状态',
      align: 'center',
      field: row => row.status,
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
      name: 'statusMean',
      label: '比赛状态',
      align: 'center',
      field: row => row.statusMean,
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
        visibleColumns: ['title','startTime','statusMean','createBy','createTime', 'judgePerson'],
        selected: [],
        dialogOpen: false,
        opt: 'add',
        params: {
          rowsPerPage: 10,
          page: 0,
          filter: null
        },
        competition: {
          id: null,
          title: null,
          startTime: ''
        }
      }
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
        })
      },
      add () {
        this.opt = 'add'
        this.competition.id = null
        this.competition.title = null
        this.competition.startTime = null

        this.dialogOpen = true
      },
      update () {
        if (this.selected.length == 0) {
          this.$q.notify({
            message: '请先选中一条数据',
            color: 'warning',
            position: 'top'
          })
        } else {
          this.opt = 'update'
          this.competition.id = this.selected[0].id
          this.competition.title = this.selected[0].title
          this.competition.startTime = this.selected[0].startTime

          this.dialogOpen = true
        }
      },
      del () {
        if (this.selected.length == 0) {
          this.$q.notify({
            message: '请先选中一条数据',
            color: 'warning',
            position: 'top'
          })
        } else {
          this.$q.notify({
            message: '确认删除已选中数据吗',
            color: 'primary',
            actions: [
              { label: '确认', color: 'yellow', handler: () => {
                  this.$api.defaults.headers.common['Authorization'] = store.user.token
                  this.$api.get('competition/delete-by-id', {
                    params: {
                      id: this.selected[0].id
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
                  })
                } },
              { label: '取消', color: 'white', handler: () => {

                } }
            ],
            position: 'center'
          })
        }
      },
      submitForm () {
        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.post('competition/saveOrUpdate', this.competition)
          .then((response) => {
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

            this.dataList()
            this.dialogOpen = false

            this.$q.notify({
              message: result.msg,
              color: 'primary',
              position: 'top'
            })
          })
      }
    }
  }
</script>
