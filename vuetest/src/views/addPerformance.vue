<template>
    <div>
        <el-form ref="user" :model="user" :rules="rules" label-width="80px" size="mini">
            <el-form-item label="id" prop="peid">
                <el-input v-model="user.peid"></el-input>
            </el-form-item>
            <el-form-item label="员工id" prop="emid">
                <el-input v-model="user.emid"></el-input>
            </el-form-item>
            <el-form-item label="name" prop="name">
                <el-input v-model="user.name"></el-input>
            </el-form-item>

            <el-form-item label="日期(年-月)" prop="date">
                <el-input v-model="user.date"></el-input>
            </el-form-item>

            <el-form-item label="等级" prop="grade">
                <el-input v-model="user.grade"></el-input>
            </el-form-item>
            <el-form-item label="备注" prop="note">
                <el-input v-model="user.note"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="onSubmit('user')">立即创建</el-button>
                <el-button @click="resetForm('user')">重置</el-button>

            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name:"addAttendance",
        data() {
            return {
                user: {
                    peid: '',
                    emid:'',
                    name: '',
                    date:'',
                    grade: '',
                    note: '',
                },
                rules: {
                    peid: [
                        {required: true, message:'id不为空',tigger:"blur"},
                        { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    emid: [
                        {required: true, message:'员工id不为空',tigger:"blur"},
                        { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ]

                },

            }

        },
        methods: {
            onSubmit(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/Performance/insert',this.user).then(function (resp) {
                            console.log(_this.user.peid)
                            console.log(resp)
                            if(resp.data.peid==_this.user.peid){
                                _this.$message({
                                    message: _this.user.peid+'添加成功',
                                    type: 'success'
                                });
                                _this.$router.push("/performance")
                            }
                        })
                    } else {
                        _this.$message({
                            showClose: true,
                            message: '添加失败',
                            type: 'warning'
                        });
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }

    }
</script>

<style scoped>

</style>