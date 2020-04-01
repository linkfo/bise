<template>
<div>
    <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="id">
        <el-input v-model="form.em_id"></el-input>
    </el-form-item>
        <el-form-item label="password">
            <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="name">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="age">
            <el-input v-model="form.age"></el-input>
        </el-form-item>

        <el-form-item label="性别">
            <el-select v-model="form.gender" placeholder="请选择性别">
                <el-option label="男" value="M"></el-option>
                <el-option label="女" value="W"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="Identity">
            <el-input v-model="form.Identity"></el-input>
        </el-form-item>
        <el-form-item label="bank_id">
            <el-input v-model="form.bank_id"></el-input>
        </el-form-item>
        <el-form-item label="tel">
            <el-input v-model="form.tel"></el-input>
        </el-form-item>
        <el-form-item label="department">
            <el-input v-model="form.department"></el-input>
        </el-form-item>
        <el-form-item label="position">
            <el-input v-model="form.position"></el-input>
        </el-form-item>
        <el-form-item label="note">
            <el-input v-model="form.note"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
</div>
</template>

<script>
    export default {
        name:"AddUser",
        data() {
            return {
                form: {
                    em_id: '',
                    password:'',
                    name: '',
                    age:'',
                    gender: '',
                    Identity: '',
                    bank_id: '',
                    tel: '',
                    department: '',
                    position: '',
                    note: '',
                    desc: ''
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        }
    }
</script>

<style scoped>

</style>