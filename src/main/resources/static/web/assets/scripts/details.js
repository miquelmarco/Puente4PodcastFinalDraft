setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                episodes: [],
                selectEp: [],
                selectedComentaries: [],
                queryId: '',
                isLoading: false
            }
        },
        created() {
            axios.get(`/api/episodes/`)
                .then(res => {
                    this.queryId = new URLSearchParams(location.search).get('id')
                    this.episodes = res.data
                    this.selectEp = this.episodes.filter(episode => episode.id == this.queryId)
                    this.selectedComentaries = this.selectEp.length > 0 ? this.selectEp[0].comentarySet : [];
                    console.log(this.selectedComentaries)
                }).catch(err => console.log(err))
        },
        methods: {
        },
        computed: {
            formattedDate() {

            }
        }
    }).mount("#app")
}, 1000)