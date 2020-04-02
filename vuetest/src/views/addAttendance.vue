<template>
    <div>
        <el-form ref="user" :model="user" :rules="rules" label-width="80px" size="mini">
            <el-form-item label="atid" prop="atid">
                <el-input v-model="user.atid"></el-input>
            </el-form-item>
            <el-form-item label="emid" prop="emid">
                <el-input v-model="user.emid"></el-input>
            </el-form-item>
            <el-form-item label="name" prop="name">
                <el-input v-model="user.name"></el-input>
            </el-form-item>

            <el-form-item label="day" prop="day">
                <el-input v-model="user.day"></el-input>
            </el-form-item>

            <el-form-item label="上午" prop="am">
                <el-select v-model="user.am" placeholder="请填写签到记录">
                    <el-option label="是" value="Y"></el-option>
                    <el-option label="后" value="N"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="下午" prop="pm">
                <el-select v-model="user.pm" placeholder="请填写签到记录">
                    <el-option label="是" value="Y"></el-option>
                    <el-option label="否" value="N"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="note" prop="note">
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
                    atid: '',
                    emid:'',
                    name: '',
                    day:'',
                    am: '',
                    pm: '',
                    note: '',
                },
                rules: {
                    atid: [
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
                        axios.post('http://localhost:8181/Attendance/insert',this.user).then(function (resp) {
                            console.log(_this.user.emid)
                            console.log(resp)
                            if(resp.data.atid==_this.user.atid){
                                _this.$message({
                                    message: _this.user.atid+'添加成功',
                                    type: 'success'
                                });
                                _this.$router.push("/attendance")
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